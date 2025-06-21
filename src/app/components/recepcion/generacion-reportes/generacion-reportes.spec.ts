import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneracionReportes } from './generacion-reportes';

describe('GeneracionReportes', () => {
  let component: GeneracionReportes;
  let fixture: ComponentFixture<GeneracionReportes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GeneracionReportes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GeneracionReportes);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
