import { Routes, RouterModule } from '@angular/router';

import { LoginComponent    } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthGuard         } from './_guards/index';
import { addgameComponent  } from "./addgame/index";
import { addcourseComponent } from "./addcourse/index";
import { homePageComponent } from "./systemHomePage/index";
import { enrollInComponent } from "./enrollIn/index";
import { coursesComponent } from "./courses/index";

import { NotificationsComponent } from "./notifications/notifications.component";
import { GameComponent } from "./game/index";





const appRoutes: Routes = [
    { path: 'home' , component: homePageComponent, canActivate: [AuthGuard] },
    { path: 'login'    , component: LoginComponent  },
    { path: 'register' , component: RegisterComponent },
    { path: 'addgame'  , component:addgameComponent  },
    { path: 'addcourse', component:addcourseComponent },
    { path: 'enrollIn', component:enrollInComponent },
    { path: 'courses', component:coursesComponent },
    { path: 'game', component:GameComponent },
    { path: 'notification', component:NotificationsComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: 'login' }
];
//
export const routing = RouterModule.forRoot(appRoutes);