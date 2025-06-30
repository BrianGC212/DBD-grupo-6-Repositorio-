import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarInformeEntrega } from './registrar-informe-entrega';

describe('RegistrarInformeEntrega', () => {
  let component: RegistrarInformeEntrega;
  let fixture: ComponentFixture<RegistrarInformeEntrega>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarInformeEntrega]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarInformeEntrega);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
