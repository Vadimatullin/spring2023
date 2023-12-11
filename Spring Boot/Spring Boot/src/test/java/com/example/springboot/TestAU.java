package com.example.springboot;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import com.tngtech.archunit.junit.AnalyzeClasses;


@AnalyzeClasses(packages = "com.example.spring2023")
public class TestAU {
    private JavaClasses importedClasses;

    @BeforeEach
    public void setup() {
        importedClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("com.springboot.testing.archunit");
    }
    @Test
    void layeredArchitectureShouldBeRespected() {

        layeredArchitecture()
                .layer("domain").definedBy("..domain..")
                .layer("app").definedBy("..app..")
                .layer("extern").definedBy("..extern..")


                .whereLayer("app").mayOnlyBeAccessedByLayers("app","extern")
                .whereLayer("extern").mayOnlyBeAccessedByLayers("extern")
                .check(importedClasses);
    }
}