package com.embeddinator.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CopyAssembliesTask extends DefaultTask {

    @TaskAction
    def run() {
        def tempDir = new File(project.buildDir, 'generated/assemblies/')
        def destDir = new File(tempDir, '/assemblies/')

        destDir.mkdir()
        project.copy {
            into destDir
            from 'src/main/assets/assemblies/'
        }
    }

    CopyAssembliesTask() {
        group = 'embeddinator'
        description = 'Copies Xamarin.Android assemblies from /assets/assemblies to /assemblies'
    }
}