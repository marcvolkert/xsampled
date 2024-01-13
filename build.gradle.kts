plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.xsampled"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.ws.xmlschema:xmlschema-core:2.3.1")
    implementation("org.apache.ws.xmlschema:xmlschema:2.3.1")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.platform:junit-platform-suite-api:1.9.3")
    testImplementation("org.junit.platform:junit-platform-suite-engine:1.9.3")
    //testImplementation("net.jqwik:jqwik:1.7.4")
    compileOnly("org.jetbrains:annotations")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}