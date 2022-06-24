import { BlogsuccessComponent } from './blogsuccess/blogsuccess.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetStartedComponent } from './get-started/get-started.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { IndexComponent } from './index/index.component';
import { TopratedComponent } from './toprated/toprated.component';
import { SearchComponent } from './search/search.component';
import { IncinemasComponent } from './incinemas/incinemas.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { RegnsuccessComponent } from './regnsuccess/regnsuccess.component';
import { AddratingComponent } from './addrating/addrating.component';
import { TrialcomponentComponent } from './trialcomponent/trialcomponent.component';
import { BlogComponent } from './blog/blog.component';
import { AddreviewComponent } from './addreview/addreview.component';
import { AdminComponent } from './admin/admin.component';
import { AdmininboxComponent } from './admininbox/admininbox.component';
import { AdminviewuserComponent } from './adminviewuser/adminviewuser.component';
import { MoviereviewComponent } from './moviereview/moviereview.component';
import { UserredirectComponent } from './userredirect/userredirect.component';
import { ThanksComponent } from './thanks/thanks.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'getstarted', component: GetStartedComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'index', component: IndexComponent },
  { path: 'toprated', component: TopratedComponent },
  { path: 'search', component: SearchComponent },
  { path: 'reviews', component: ReviewsComponent },
  { path: 'incinemas', component: IncinemasComponent },
  { path: 'regnsuccess', component: RegnsuccessComponent },
  { path: 'addrating', component: AddratingComponent },
  { path: 'addreview', component: AddreviewComponent },
  { path: 'blogsuccess', component: BlogsuccessComponent },
  { path: 'trial', component: TrialcomponentComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'admin.viewuser', component: AdminviewuserComponent },
  { path: 'admin.inbox', component: AdmininboxComponent },
  { path: 'moviereview', component: MoviereviewComponent },
  { path: 'userredirect', component: UserredirectComponent },
  { path: 'thanks', component: ThanksComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
