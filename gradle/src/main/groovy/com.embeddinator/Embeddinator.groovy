package com.embeddinator

import com.embeddinator.task.AaptOptionsTask
import com.embeddinator.task.CopyAssembliesTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class Embeddinator implements Plugin<Project> {

    @Override
    void apply(Project project) {

        //aaptOptions
        project.task('aaptOptionsForEmbeddinator', type: AaptOptionsTask)
        project.tasks.getByName('preBuild').dependsOn('aaptOptionsForEmbeddinator')

        //Copy assemblies
        project.task('copyEmbeddinatorAssemblies', type: CopyAssembliesTask)
        project.afterEvaluate {
            project.tasks.findAll { t ->
                t.name.startsWith('merge') && t.name.endsWith('Resources')
            }.each { t -> t.dependsOn 'copyEmbeddinatorAssemblies' }
        }
    }
}