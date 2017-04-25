import { Routes, RouterModule } from '@angular/router';

import { LoginComponent    } from './login/index';
import { RegisterComponent } from './register/index';
import { AuthGuard         } from './_guards/index';
import { addgameComponent  } from "./addgame/index";
import { courseComponent   } from "./course/index";
import { tfgameComponent   } from "./tfgame/index";
import { cgameComponent } from "./choicegame/index";
import { addcourseComponent } from "./addcourse/index";
import { homePageComponent } from "./systemHomePage/index";



const appRoutes: Routes = [
    { path: 'home' , component: homePageComponent, canActivate: [AuthGuard] },
    { path: 'login'    , component: LoginComponent },
    { path: 'register' , component: RegisterComponent },
    { path: 'addgame'  , component:addgameComponent},
    { path: 'course'   , component:courseComponent},
    { path: 'tfgame'   , component:tfgameComponent},
    { path: 'cgame'    , component:cgameComponent},
    { path: 'addcourse', component:addcourseComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];
//
export const routing = RouterModule.forRoot(appRoutes);