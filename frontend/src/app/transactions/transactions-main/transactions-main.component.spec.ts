import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionsMainComponent } from './transactions-main.component';

describe('TransactionsMainComponent', () => {
  let component: TransactionsMainComponent;
  let fixture: ComponentFixture<TransactionsMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionsMainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionsMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
