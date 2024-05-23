package io.minimal.example.teavm

import java.io.File
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuildConfiguration
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuilder
import com.github.xpenatan.gdx.backends.teavm.config.plugins.TeaReflectionSupplier
import com.github.xpenatan.gdx.backends.teavm.gen.SkipClass
import io.minimal.example.PositionC

/** Builds the TeaVM/HTML application. */
@SkipClass
object TeaVMBuilder {
    @JvmStatic fun main(arguments: Array<String>) {
        val teaBuildConfiguration = TeaBuildConfiguration().apply {
            assetsPath.add(File("../assets"))
            webappPath = File("build/dist").canonicalPath
            // Register any extra classpath assets here:
            // additionalAssetsClasspathFiles += "io/minimal/example/asset.extension"
        }

        // Register any classes or packages that require reflection here:
//         TeaReflectionSupplier.addReflectionClass("io.minimal.example.reflect")
        TeaReflectionSupplier.addReflectionClass(PositionC::class.qualifiedName)

        val tool = TeaBuilder.config(teaBuildConfiguration)
        tool.mainClass = "io.minimal.example.teavm.TeaVMLauncher"
        TeaBuilder.build(tool)
    }
}
