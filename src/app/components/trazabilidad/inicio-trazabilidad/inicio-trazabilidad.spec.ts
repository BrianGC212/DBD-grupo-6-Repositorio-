import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InicioTrazabilidad } from './inicio-trazabilidad';

describe('InicioTrazabilidad', () => {
  let component: InicioTrazabilidad;
  let fixture: ComponentFixture<InicioTrazabilidad>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InicioTrazabilidad]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InicioTrazabilidad);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
