import { Component, OnInit } from '@angular/core';
import {TransactionsService} from "../transactions.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable, tap} from "rxjs";
import {Transaction} from "../../models/Transaction";

@Component({
  selector: 'app-edit-transaction',
  templateUrl: './edit-transaction.component.html',
  styleUrls: ['./edit-transaction.component.css']
})
export class EditTransactionComponent implements OnInit {

  public transaction$!: Observable<Transaction>;
  public transaction?: Transaction;
  public waiting!: boolean;

  constructor(
    private transactionsService: TransactionsService,
    private route: ActivatedRoute,
    public router: Router
  ) { }

  ngOnInit(): void {
    this.waiting = false;
    let map = this.route.snapshot.queryParamMap;
    let id = map.get("id");
    if (id == null) {
      this.router.navigate([""]);
    }

    // @ts-ignore
    this.transaction$ = this.transactionsService.getTransaction(id).pipe(
      tap(transaction => this.transaction = transaction)
    );
  }

  onSubmit() {
    if (this.transaction) {
      this.waiting = true;
      this.transactionsService.updateTransaction(this.transaction).subscribe(
        value => this.router.navigate(["transactions", "info"], {queryParams: {id: value.id}})
      )
    }
  }

  onCancel() {
    if (this.transaction) {
      this.waiting = true;
      this.router.navigate(["transactions", "info"], {queryParams: {id: this.transaction.id}})
    }
  }
}
