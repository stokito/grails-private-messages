Grails Private Messages
=======================
Plugin that allow your users to send private messages to each others.
Plugin is currenly under development.
It depends on Joda Time and Spring Security Core plugins.

Installation
================
Please add the following repository and dependency to your BuildConfig.groovy:

    grails.project.dependency.resolution = {

        repositories {
            ...
            mavenRepo 'http://dl.bintray.com/stokito/maven'
        }

        ...

        plugins {
            ...
            compile 'name.stokito:grails-private-messages:0.2'
            // dependencies
            compile ':spring-security-core:1.2.7.3'
            compile ':joda-time:1.4'
        }

    }



 
