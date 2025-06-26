import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreparacionPedidos } from './preparacion-pedidos';

describe('PreparacionPedidos', () => {
  let component: PreparacionPedidos;
  let fixture: ComponentFixture<PreparacionPedidos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PreparacionPedidos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PreparacionPedidos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
