plugins {
    id("java")
    application
    checkstyle
    id("com.github.ben-manes.versions") version "0.51.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("io.freefair.lombok") version "8.6"
    jacoco
}

group = "org.martinmeer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass.set("org.martinmeer.Main")
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.2")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("info.picocli:picocli:4.7.6")
    implementation("org.postgresql:postgresql:42.7.2")

    //Lombok
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")

    //test
    testImplementation("org.assertj:assertj-core:3.26.0")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    //Spring
    implementation("org.springframework:spring-aop:6.2.1")
    implementation("org.springframework:spring-web:6.2.1")
    implementation("org.springframework:spring-core:6.2.1")
    implementation("org.springframework:spring-context:6.2.1")
    implementation("org.springframework:spring-beans:6.2.1")

    //other
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")

}

//tasks
tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs
    compilerArgs.add("-Aproject=${project.group}/${project.name}")
}
tasks.test {
    useJUnitPlatform()
}
tasks.test {
    finalizedBy(tasks.jacocoTestReport) // report is always generated after tests run
}
tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
}
tasks.jacocoTestReport {
    reports {
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}









