package com.matteopasotti.bdd_sample.test

import cucumber.api.CucumberOptions


@CucumberOptions(features = ["features"],
    glue = ["com.matteopasotti.bdd_sample.steps"],
    tags = ["transfer"])
class CucumberTestClass