import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers/index';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService, achievementService, CourseService, GameService } from './_services/index';

import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { addgameComponent } from "./addgame/index"; //me4 
import { courseComponent } from "./course/index";
import { tfgameComponent } from "./tfgame/index";
import { cgameComponent } from "./choicegame/index";
import { addcourseComponent } from "./addcourse/index";
import { homePageComponent } from "./systemHomePage/index";
// 

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        routing,

    ],
    declarations: [
        AppComponent,
        AlertComponent,
        LoginComponent,
        RegisterComponent,
        addgameComponent,
        courseComponent,
        tfgameComponent,
        cgameComponent,
        addcourseComponent,
        homePageComponent
    

    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        GameService,
        CourseService,
        achievementService,

        // providers used to create fake backend
        fakeBackendProvider,
        MockBackend,
        BaseRequestOptions
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }