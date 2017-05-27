package com.embeddinator

import com.embeddinator.task.AaptOptionsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class Embeddinator implements Plugin<Project> {

    @Override
    void apply(Project project) {

        //aaptOptions
        project.task('aaptOptionsForEmbeddinator', type: AaptOptionsTask)
        project.tasks.getByName('preBuild').dependsOn('aaptOptionsForEmbeddinator')
    }
}