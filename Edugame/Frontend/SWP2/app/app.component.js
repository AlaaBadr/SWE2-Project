System.register(['angular2/core', "./Size.directive", "./form.component", "./welcome.component", "./search.component", "./tf.component", "./choice.component", "./add.component", "./course.compnent", "./courses.component", "./homepage.component"], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, Size_directive_1, form_component_1, welcome_component_1, search_component_1, tf_component_1, choice_component_1, add_component_1, course_compnent_1, courses_component_1, homepage_component_1;
    var AppComponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (Size_directive_1_1) {
                Size_directive_1 = Size_directive_1_1;
            },
            function (form_component_1_1) {
                form_component_1 = form_component_1_1;
            },
            function (welcome_component_1_1) {
                welcome_component_1 = welcome_component_1_1;
            },
            function (search_component_1_1) {
                search_component_1 = search_component_1_1;
            },
            function (tf_component_1_1) {
                tf_component_1 = tf_component_1_1;
            },
            function (choice_component_1_1) {
                choice_component_1 = choice_component_1_1;
            },
            function (add_component_1_1) {
                add_component_1 = add_component_1_1;
            },
            function (course_compnent_1_1) {
                course_compnent_1 = course_compnent_1_1;
            },
            function (courses_component_1_1) {
                courses_component_1 = courses_component_1_1;
            },
            function (homepage_component_1_1) {
                homepage_component_1 = homepage_component_1_1;
            }],
        execute: function() {
            AppComponent = (function () {
                function AppComponent() {
                }
                AppComponent = __decorate([
                    core_1.Component({
                        selector: 'my-app',
                        template: "<form></form>",
                        directives: [add_component_1.addcomponent, choice_component_1.choicecomponent, course_compnent_1.coursecomponent, courses_component_1.coursescomponent, form_component_1.formcomponent, homepage_component_1.homepagecomponent, search_component_1.searchcomponent,
                            Size_directive_1.Sizedirective, tf_component_1.tfcomponent, welcome_component_1.welcomecomponent]
                    }), 
                    __metadata('design:paramtypes', [])
                ], AppComponent);
                return AppComponent;
            }());
            exports_1("AppComponent", AppComponent);
        }
    }
});
/*
<add></add>
<tf></tf>
<course></course>
<form></form>
<search></search>
<welcome></welcome>
*/ 
//# sourceMappingURL=app.component.js.map