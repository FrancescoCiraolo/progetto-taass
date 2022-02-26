import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {CommonModule} from '@angular/common';
import {TransactionInfoComponent} from "./transactions/transaction-info/transaction-info.component";
import {TransactionsMainComponent} from "./transactions/transactions-main/transactions-main.component";
import {NewTransactionComponent} from "./transactions/new-transaction/new-transaction.component";
import {EditTransactionComponent} from "./transactions/edit-transaction/edit-transaction.component";
// import {TransactionsComponent} from "./transactions/transactions.component";
// import {TransactionInfoComponent} from "./transactions/transaction-info/transaction-info.component";

const routes: Routes = [
  {
    path: "transactions",
    component: TransactionsMainComponent,
    // children: [
    //   {
    //     path: "info",
    //     component: TransactionInfoComponent
    //   }
    // ]
  },
  {
    path: "transactions/info",
    component: TransactionInfoComponent
  },
  {
    path: "transactions/new",
    component: NewTransactionComponent
  },
  {
    path: "transactions/edit",
    component: EditTransactionComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})

export class AppRoutingModule {

}
