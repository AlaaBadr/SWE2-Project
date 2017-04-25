import { Routes, RouterModule } from '@angular/router';

import { LoginComponent    } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthGuard         } from './_guards/index';
import { addgameComponent  } from "./addgame/index";
import { gameComponent     } from "./game/index";
import { addcourseComponent } from "./addcourse/index";
import { homePageComponent } from "./systemHomePage/index";
import { enrollInComponent } from "./enrollIn/index";
import { coursesComponent } from "./courses/index";



const appRoutes: Routes = [
    { path: 'home' , component: homePageComponent, canActivate: [AuthGuard] },
    { path: 'login'    , component: LoginComponent  },
    { path: 'register' , component: RegisterComponent },
    { path: 'addgame'  , component:addgameComponent  },
    { path: 'game'    , component:gameComponent },
    { path: 'addcourse', component:addcourseComponent },
    { path: 'enrollIn', component:enrollInComponent },
    { path: 'courses', component:coursesComponent },
    // otherwise redirect to home
    { path: '**', redirectTo: 'login' }
];
//
export const routing = RouterModule.forRoot(appRoutes);