import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarProgramaciones } from './visualizar-programaciones';

describe('VisualizarProgramaciones', () => {
  let component: VisualizarProgramaciones;
  let fixture: ComponentFixture<VisualizarProgramaciones>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarProgramaciones]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarProgramaciones);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
