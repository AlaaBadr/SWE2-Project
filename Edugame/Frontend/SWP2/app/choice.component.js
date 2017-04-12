System.register(['angular2/core', "./navbar.component"], function(exports_1, context_1) {
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
    var core_1, navbar_component_1;
    var choicecomponent;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (navbar_component_1_1) {
                navbar_component_1 = navbar_component_1_1;
            }],
        execute: function() {
            choicecomponent = (function () {
                function choicecomponent() {
                    this.Answer1 = "";
                    this.Answer2 = "";
                    this.Answer3 = "";
                    this.Answer4 = "";
                    this.RAnswer = "";
                }
                choicecomponent = __decorate([
                    core_1.Component({
                        selector: 'choice',
                        templateUrl: 'app/hmtlcomponent/choice.html',
                        directives: [navbar_component_1.navbarcomponent]
                    }), 
                    __metadata('design:paramtypes', [])
                ], choicecomponent);
                return choicecomponent;
            }());
            exports_1("choicecomponent", choicecomponent);
        }
    }
});
//# sourceMappingURL=choice.component.js.map