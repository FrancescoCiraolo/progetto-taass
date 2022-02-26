import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private _userID?: number = 1;
  private _eventID?: number = 2;
  private _eventGroupID?: number = 3;

  constructor() {
  }

  get userID(): number | undefined {
    return this._userID;
  }

  get eventID(): number | undefined {
    return this._eventID;
  }

  get eventGroupID(): number | undefined {
    return this._eventGroupID;
  }
}
