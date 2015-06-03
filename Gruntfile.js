module.exports = function (grunt)
{
    'use strict';

    grunt.initConfig({

        jshint: {
            options: {
                jshintrc: '.jshintrc'
            },
            all: {
                src: ['app/**/*.js', 'spec/**/*.js']
            }
        },
        karma: {
            unit: {
                configFile: 'spec/karma.conf.js',
                singleRun: true
            }
        }

    });

    grunt.loadNpmTasks('grunt-contrib-jshint');

};
