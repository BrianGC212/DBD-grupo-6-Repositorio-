import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListasPicking } from './listas-picking';

describe('ListasPicking', () => {
  let component: ListasPicking;
  let fixture: ComponentFixture<ListasPicking>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListasPicking]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListasPicking);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
