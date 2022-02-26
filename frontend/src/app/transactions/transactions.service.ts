import { Injectable } from '@angular/core';
import {Transaction} from "../models/Transaction";
import {Observable, of} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TransactionsService {

  private baseURL = "http://localhost:8762/transactions";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
  ) { }

  public getTransaction (id: number): Observable<Transaction> {

    const url = `${this.baseURL}/get-transaction?id=${id}`;

    return this.http.get<Transaction>(url).pipe(
      // tap(_ => this.log(`fetched hero id=${id}`)),
      // catchError(this.handleError<Hero>(`getHero id=${id}`))
    );
  }

  public newTransaction (transaction: Transaction) : Observable<Transaction> {

    const url = `${this.baseURL}/add-transaction`;

    return this.http.post<Transaction>(url, transaction, this.httpOptions);

  }

  public updateTransaction (transaction: Transaction) : Observable<Transaction> {

    const url = `${this.baseURL}/update-transaction`;

    return this.http.post<Transaction>(url, transaction, this.httpOptions);

  }
}
