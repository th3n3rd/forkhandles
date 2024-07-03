import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

description = "ForkHandles Value-types library"

dependencies {
    implementation(project(":result4k"))
}


tasks.withType<KotlinJvmCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs.set(freeCompilerArgs.get() + "-Xinline-classes")
    }
}
