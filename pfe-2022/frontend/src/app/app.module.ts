import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule,ReactiveFormsModule  } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatCardModule} from '@angular/material/card'
import {MatChipsModule} from '@angular/material/chips'
import { MatTableModule } from '@angular/material/table';

import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule} from '@angular/material/icon'
import { AppComponent } from './app.component';
import {A11yModule} from '@angular/cdk/a11y';
import {ClipboardModule} from '@angular/cdk/clipboard';

import {DragDropModule} from '@angular/cdk/drag-drop';
import {PortalModule} from '@angular/cdk/portal';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {CdkStepperModule} from '@angular/cdk/stepper';
import {CdkTableModule} from '@angular/cdk/table';
import {CdkTreeModule} from '@angular/cdk/tree';
import {MatBadgeModule} from '@angular/material/badge';
import { MatInputModule } from '@angular/material/input';
import {MatBottomSheetModule} from '@angular/material/bottom-sheet';
import {MatButtonModule} from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatStepperModule} from '@angular/material/stepper';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatDialogModule} from '@angular/material/dialog';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatListModule} from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import {MatNativeDateModule, MatRippleModule} from '@angular/material/core';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTabsModule} from '@angular/material/tabs';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatTreeModule} from '@angular/material/tree';
import {OverlayModule} from '@angular/cdk/overlay';
import { DatePipe } from '@angular/common';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { HttpClient } from '@angular/common/http';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { HttpInterceptor, HttpEvent, HttpResponse, HttpRequest, HttpHandler } from '@angular/common/http';
import{NgbModalModule}from '@ng-bootstrap/ng-bootstrap';
import { NgBootstrapFormValidationModule } from 'ng-bootstrap-form-validation';
import { DateRangePickerModule } from '@syncfusion/ej2-angular-calendars';
import { DetailComponent } from './reservation/detail/detail.component';
import { ListComponent } from './reservation/list/list.component';
import { AddComponent } from './reservation/add/add.component';
import { EditComponent } from './reservation/edit/edit.component';
import { DeleteModalComponent } from './reservation/delete-modal/delete-modal.component';
import { DatePickerModule } from '@syncfusion/ej2-angular-calendars';
import { AddresearchComponent } from './CustomerResearch/addresearch/addresearch.component';
import { ListresearchComponent } from './CustomerResearch/listresearch/listresearch.component';
import { EditresearchComponent } from './CustomerResearch/editresearch/editresearch.component';
import { DetailresearchComponent } from './CustomerResearch/detailresearch/detailresearch.component';
import { NgbModule,NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { ReccurenteComponent } from './CustomerResearch/reccurente/reccurente.component';
import { NgxHijriGregorianDatepickerModule } from 'ngx-hijri-gregorian-datepicker';
import { StatisticalComponent } from './statistical/statistical.component';
import { NgxSpinnerModule } from 'ngx-spinner';
import { DetailmouiinaComponent } from './Mouiina/detailmouiina/detailmouiina.component';




import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProfileComponent } from './profile/profile.component';
import { authInterceptorProviders } from './_helpers/auth.service';
import { ReclamCustomerComponent } from './reclam-customer/reclam-customer.component';
import { RateComponent } from './reservation/rate/rate.component';
import { PreferencesComponent } from './preferences/preferences.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { RateagentComponent } from './rateagent/rateagent.component';
import { ComplainlistComponent } from './complainlist/complainlist.component';
import { PreferenceBlacklistComponent } from './preference-blacklist/preference-blacklist.component';
import { PreferenceListComponent } from './preference-list/preference-list.component';
import { MatConfirmDialogComponent } from './mat-confirm-dialog/mat-confirm-dialog.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/lang/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    EditComponent,
    ListComponent,
    DetailComponent,
    DeleteModalComponent,
    AddresearchComponent,
    ListresearchComponent,
    EditresearchComponent,
    DetailresearchComponent,
    ReccurenteComponent,
    StatisticalComponent,
    DetailmouiinaComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    ReclamCustomerComponent,
    RateComponent,
    
    PreferencesComponent,
    UpdatecustomerComponent,
    RateagentComponent,
    ComplainlistComponent,
    PreferenceBlacklistComponent,
    PreferenceListComponent,
    MatConfirmDialogComponent,
    ForgotPasswordComponent,

  ],
  imports: [
      FormsModule,
      ReactiveFormsModule,
      BrowserModule,
      AppRoutingModule,
      BrowserAnimationsModule,
      MatIconModule,
      AppRoutingModule,
      HttpClientModule,
      MatChipsModule,
      MatAutocompleteModule,
      MatTableModule,
      MatPaginatorModule,
      MatSortModule,
      MatInputModule,
      MatIconModule,
      BrowserAnimationsModule,
      A11yModule,
      ClipboardModule,
      CdkStepperModule,
      CdkTableModule,
      CdkTreeModule,
      DragDropModule,
      MatAutocompleteModule,
      MatBadgeModule,
      MatBottomSheetModule,
      MatButtonModule,
      MatButtonToggleModule,
      MatCardModule,
      MatCheckboxModule,
      MatChipsModule,
      MatStepperModule,
      MatDatepickerModule,
      MatDialogModule,
      MatDividerModule,
      MatExpansionModule,
      MatGridListModule,
    
      MatListModule,
      MatMenuModule,
      MatNativeDateModule,
      MatProgressBarModule,
      MatProgressSpinnerModule,
      MatRadioModule,
      MatRippleModule,
      MatSelectModule,
      MatSidenavModule,
      MatSliderModule,
      MatSlideToggleModule,
      MatSnackBarModule,
      MatSortModule,
      MatTableModule,
      MatTabsModule,
      MatToolbarModule,
      MatTooltipModule,
      MatTreeModule,
      OverlayModule,
      PortalModule,
      ScrollingModule,
      NgxMaterialTimepickerModule,
      NgbModalModule,
      DatePickerModule,
      NgbModule,
      DateRangePickerModule,
      NgxHijriGregorianDatepickerModule,
      NgxSpinnerModule,
      NgBootstrapFormValidationModule.forRoot(),
      TranslateModule.forRoot({
       defaultLanguage: 'en-US',
        loader: {
            provide: TranslateLoader,
            useFactory: HttpLoaderFactory,
            deps: [HttpClient]
        }
    })
  ],

  providers: [DatePipe,authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
