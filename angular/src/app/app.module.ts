import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgToastModule } from 'ng-angular-popup';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetStartedComponent } from './get-started/get-started.component';
import { FooterComponent } from './footer/footer.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { IndexComponent } from './index/index.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { TopratedComponent } from './toprated/toprated.component';
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { IncinemasComponent } from './incinemas/incinemas.component';
import { ApireqService } from './apireq.service';
import { RegnsuccessComponent } from './regnsuccess/regnsuccess.component';
import { AddratingComponent } from './addrating/addrating.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { BlogsuccessComponent } from './blogsuccess/blogsuccess.component';
import { TrialcomponentComponent } from './trialcomponent/trialcomponent.component';
import { BlogComponent } from './blog/blog.component';
import { AddreviewComponent } from './addreview/addreview.component';
import { AdminComponent } from './admin/admin.component';
import { AdmininboxComponent } from './admininbox/admininbox.component';
import { AdminviewuserComponent } from './adminviewuser/adminviewuser.component';
import { MoviereviewComponent } from './moviereview/moviereview.component';
import { UserredirectComponent } from './userredirect/userredirect.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { ThanksComponent } from './thanks/thanks.component';

@NgModule({
  declarations: [
    AppComponent,
    GetStartedComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    IndexComponent,
    TopratedComponent,
    HeaderComponent,
    SearchComponent,
    ReviewsComponent,
    IncinemasComponent,
    RegnsuccessComponent,
    AddratingComponent,
    BlogsuccessComponent,
    TrialcomponentComponent,
    BlogComponent,
    AddreviewComponent,
    AdminComponent,
    AdmininboxComponent,
    AdminviewuserComponent,
    MoviereviewComponent,
    UserredirectComponent,
    ThanksComponent,
  ],
  imports: [
    BrowserModule,
    MatAutocompleteModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgToastModule,
    HttpClientModule,
    HttpClientModule,
    MatIconModule,
    RouterModule.forRoot([{ path: 'home', component: HomeComponent }]),
    NoopAnimationsModule,
  ],
  providers: [ApireqService],
  bootstrap: [AppComponent],
})
export class AppModule {}
