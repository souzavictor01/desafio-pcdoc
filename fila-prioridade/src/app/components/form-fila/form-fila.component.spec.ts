import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFilaComponent } from './form-fila.component';

describe('FormFilaComponent', () => {
  let component: FormFilaComponent;
  let fixture: ComponentFixture<FormFilaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormFilaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormFilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
