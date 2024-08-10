description = "ForkHandles: The very cheapest mocking framework platform."

dependencies {
    testImplementation(KotlinX.coroutines.core)

    testImplementation(platform("org.junit:junit-bom:_"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
