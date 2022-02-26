import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Transaction} from "../../models/Transaction";
import {TransactionsService} from "../transactions.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-transaction-info',
  templateUrl: './transaction-info.component.html',
  styleUrls: ['./transaction-info.component.css']
})
export class TransactionInfoComponent implements OnInit {

  public transaction$!: Observable<Transaction>;

  constructor(
    private transactionsService: TransactionsService,
    private route: ActivatedRoute,
    public router: Router
  ) { }

  ngOnInit(): void {
    let map = this.route.snapshot.queryParamMap;
    let id = map.get("id");
    if (id == null) {
      this.router.navigate([""]);
    }

    // @ts-ignore
    this.transaction$ = this.transactionsService.getTransaction(id);
  }

  onUpdate(id: number) {
    this.router.navigate(["transactions", "edit"], {queryParams: {id: id}})
  }
}
