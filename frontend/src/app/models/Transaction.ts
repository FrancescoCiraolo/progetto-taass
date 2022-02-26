export class Transaction {

  constructor(
    public id: number,
    public eventID: number,
    public debtorID: number,
    public creditorID: number,
    public date: String | null,
    public value: number,
    public currency: String,
    public details?: String,
    public imageUrl?: String,
  ) {
  }
}
