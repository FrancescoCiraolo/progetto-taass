import {Component, OnInit} from '@angular/core';
import {TransactionsService} from "../transactions.service";
import {Transaction} from "../../models/Transaction";
import {AppService} from "../../app.service";
import {Router} from "@angular/router";

import {DatePipe} from '@angular/common'

@Component({
  selector: 'app-new-transaction',
  templateUrl: './new-transaction.component.html',
  styleUrls: ['./new-transaction.component.css']
})
export class NewTransactionComponent implements OnInit {

  public transaction!: Transaction;

  public waiting!: boolean;

  constructor(
    public appService: AppService,
    public transactionsService: TransactionsService,
    public router: Router,
    public datePipe: DatePipe
  ) {
  }

  ngOnInit(): void {
    this.waiting = false;

    if (
      this.appService.eventID == undefined ||
      this.appService.eventGroupID == undefined ||
      this.appService.userID == undefined)
      this.router.navigate([]);

    this.transaction = {
      id: -1,
      eventID: this.appService.eventID ? this.appService.eventID : -1,
      debtorID: this.appService.eventGroupID ? this.appService.eventGroupID : -1,
      creditorID: this.appService.userID ? this.appService.userID : -1,
      date: this.datePipe.transform(new Date(), "yyyy/MM/dd hh:mm"),
      value: 0.0,
      currency: "EUR"
    }
  }

  onSubmit() {
    this.waiting = true;
    this.transactionsService.newTransaction(this.transaction)
      .subscribe(value => this.router.navigate(['transactions', 'info'], {queryParams: {id: value.id}}))
  }
}
