package com.embeddinator.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AaptOptionsNoCompressDllTask extends DefaultTask {

    @TaskAction
    def run() {
        project.configure(project) {
            if (it.hasProperty("android")) {
                project.android.aaptOptions.setProperty('noCompress', 'dll')
            }
        }
    }

    AaptOptionsNoCompressDllTask() {
        group = 'embeddinator'
        description = 'Applies noCompress \'dll\' to aaptOptions'
    }
}