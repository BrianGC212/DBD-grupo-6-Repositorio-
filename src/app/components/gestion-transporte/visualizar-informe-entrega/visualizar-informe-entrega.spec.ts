import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarInformeEntrega } from './visualizar-informe-entrega';

describe('VisualizarInformeEntrega', () => {
  let component: VisualizarInformeEntrega;
  let fixture: ComponentFixture<VisualizarInformeEntrega>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarInformeEntrega]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarInformeEntrega);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
