import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EquiposRegistrados } from './equipos-registrados';

describe('EquiposRegistrados', () => {
  let component: EquiposRegistrados;
  let fixture: ComponentFixture<EquiposRegistrados>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EquiposRegistrados]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EquiposRegistrados);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
