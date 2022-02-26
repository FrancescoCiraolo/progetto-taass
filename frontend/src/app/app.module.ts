import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';
import { DatePipe } from '@angular/common';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { TransactionInfoComponent } from './transactions/transaction-info/transaction-info.component';
import { TransactionsMainComponent } from './transactions/transactions-main/transactions-main.component';
import { NewTransactionComponent } from './transactions/new-transaction/new-transaction.component';
import { EditTransactionComponent } from './transactions/edit-transaction/edit-transaction.component';

@NgModule({
  declarations: [
    AppComponent,
    TransactionInfoComponent,
    TransactionsMainComponent,
    NewTransactionComponent,
    EditTransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
