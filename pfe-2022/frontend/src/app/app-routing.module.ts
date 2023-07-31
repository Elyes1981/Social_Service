import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DetailComponent } from './reservation/detail/detail.component';
import { ListComponent } from './reservation/list/list.component';
import { AddComponent } from './reservation/add/add.component';
import { EditComponent } from './reservation/edit/edit.component';
import { DeleteModalComponent } from './reservation/delete-modal/delete-modal.component';
import { AddresearchComponent } from './CustomerResearch/addresearch/addresearch.component';
import { DetailresearchComponent } from './CustomerResearch/detailresearch/detailresearch.component';
import { ListresearchComponent } from './CustomerResearch/listresearch/listresearch.component';
import { EditresearchComponent } from './CustomerResearch/editresearch/editresearch.component';
import { ReccurenteComponent } from './CustomerResearch/reccurente/reccurente.component';
import { StatisticalComponent } from './statistical/statistical.component';
import { DetailmouiinaComponent } from './Mouiina/detailmouiina/detailmouiina.component';


import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { ReclamCustomerComponent } from './reclam-customer/reclam-customer.component'; 
import { RateComponent } from './reservation/rate/rate.component';
import { UpdatecustomerComponent } from './updatecustomer/updatecustomer.component';
import { RateagentComponent } from './rateagent/rateagent.component';
import { ComplainlistComponent } from './complainlist/complainlist.component';
import { PreferenceBlacklistComponent } from './preference-blacklist/preference-blacklist.component';
import { PreferenceListComponent } from './preference-list/preference-list.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
const routes: Routes = [

  { path: 'list', component: ListComponent },
  { path: 'add', component: AddComponent },
  { path: 'edit/:id', component: EditComponent },
  { path: 'reccurente', component: ReccurenteComponent },
  { path: 'detail/:id', component: DetailComponent },
  { path: 'pref_black/:id', component: PreferenceBlacklistComponent },
  { path: 'reclam', component: ReclamCustomerComponent },
  { path: 'rating/:id', component: RateComponent },
  { path: 'rating', component: RateComponent },
  { path: 'rateAgent', component: RateagentComponent },

  { path: 'complainlist', component: ComplainlistComponent },
  { path: 'pref_list', component: PreferenceListComponent },
  { path: 'forgot_password', component: ForgotPasswordComponent },

  { path: 'update/:id', component: UpdatecustomerComponent },

  { path: 'listresearch', component: ListresearchComponent },
  { path: 'editresearch/:id', component: EditresearchComponent },
  { path: 'addResearch', component: AddresearchComponent },
  { path: 'detailresearch/:id', component: DetailresearchComponent },
  { path: 'Statistical', component: StatisticalComponent },
  { path: 'detailMou3ina/:id', component: DetailmouiinaComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
