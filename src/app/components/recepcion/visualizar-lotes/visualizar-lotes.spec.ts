import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VisualizarLotes } from './visualizar-lotes';

describe('VisualizarLotes', () => {
  let component: VisualizarLotes;
  let fixture: ComponentFixture<VisualizarLotes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VisualizarLotes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VisualizarLotes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
