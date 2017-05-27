package com.embeddinator.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class AaptOptionsTask extends DefaultTask {

    @TaskAction
    def run() {
        project.configure(project) {
            if (it.hasProperty("android")) {
                def aaptOptions = project.android.aaptOptions

                //NOTE: .NET assemblies need to be uncompressed for mmap
                aaptOptions.setProperty('noCompress', 'dll')

                //NOTE: exclude assets/assemblies, because they will get added to /assemblies instead
                aaptOptions.setProperty('ignoreAssetsPattern', '!*.dll')
            }
        }
    }

    AaptOptionsTask() {
        group = 'embeddinator'
        description = 'Applies aaptOptions settings for embeddinator'
    }
}