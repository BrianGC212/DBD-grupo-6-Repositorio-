import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarOrdenesTransporte } from './visualizar-ordenes-transporte';

describe('VisualizarOrdenesTransporte', () => {
  let component: VisualizarOrdenesTransporte;
  let fixture: ComponentFixture<VisualizarOrdenesTransporte>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarOrdenesTransporte]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarOrdenesTransporte);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
