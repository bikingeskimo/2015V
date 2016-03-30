import {Component, OnInit} from 'angular2/core';
import {RouteParams} from 'angular2/router';

import {Customer, CustomersService} from '../services/customers';

@Component({
  templateUrl: 'app/templates/customer.html' //The template (view) of this component
})

//Component corresponds to the controller in MVC, or the view model in MVVM
export class CustomerComponent implements OnInit {
  customer:Customer;
  
  //Parameters of the constructor are inserted automatically by Angular 2
  constructor(customersService:CustomersService, params:RouteParams) {
    this.customer=customersService.getCustomer(+params.get('id')); //'+'converts to int, parseInt is bugged
  }
  
  ngOnInit() {}
}