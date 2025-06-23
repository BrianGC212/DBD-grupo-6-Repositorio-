import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarOrdenTransporte } from './registrar-orden-transporte';

describe('RegistrarOrdenTransporte', () => {
  let component: RegistrarOrdenTransporte;
  let fixture: ComponentFixture<RegistrarOrdenTransporte>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarOrdenTransporte]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarOrdenTransporte);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
