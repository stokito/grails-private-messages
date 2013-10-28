grails.project.work.dir = 'target'

grails.project.repos.default = 'bintray-stokito-grails-private-messages'
grails.project.repos.'bintray-stokito-maven-grails-private-messages'.url = 'https://api.bintray.com/maven/stokito/maven/grails-private-messages'
grails.project.repos.'bintray-stokito-maven-grails-private-messages'.type = 'maven'
grails.project.repos.'bintray-stokito-maven-grails-private-messages'.portal = 'stokitoBintray'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()
    }

    dependencies {
    }

    plugins {
        build ':release:3.0.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}
