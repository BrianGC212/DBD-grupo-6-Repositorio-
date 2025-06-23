import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarGuiasRemision } from './visualizar-guias-remision';

describe('VisualizarGuiasRemision', () => {
  let component: VisualizarGuiasRemision;
  let fixture: ComponentFixture<VisualizarGuiasRemision>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarGuiasRemision]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarGuiasRemision);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
