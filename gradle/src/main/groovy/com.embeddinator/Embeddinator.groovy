package com.embeddinator

import com.embeddinator.task.AaptOptionsNoCompressDllTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class Embeddinator implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('aaptOptionsNoCompressDll', type: AaptOptionsNoCompressDllTask)
        project.tasks.getByName('preBuild').dependsOn('aaptOptionsNoCompressDll')
    }
}