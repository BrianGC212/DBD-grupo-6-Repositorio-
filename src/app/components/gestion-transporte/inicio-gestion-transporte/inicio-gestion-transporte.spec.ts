import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioGestionTransporte } from './inicio-gestion-transporte';

describe('InicioGestionTransporte', () => {
  let component: InicioGestionTransporte;
  let fixture: ComponentFixture<InicioGestionTransporte>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InicioGestionTransporte]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InicioGestionTransporte);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
