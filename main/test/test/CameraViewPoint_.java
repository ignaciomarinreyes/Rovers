package test;

import org.junit.Before;
import org.junit.Test;
import refactoring.Camera;
import refactoring.ImageProcessor;
import refactoring.ViewPoint;
import viewPoint.CameraViewPoint;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CameraViewPoint_ {

    private ViewPoint initialViewPoint;
    private Camera camera;

    @Before
    public void setUp () {
        camera = mock(Camera.class);
        ImageProcessor imageProcessor = mock(ImageProcessor.class);
        initialViewPoint = new CameraViewPoint(camera, imageProcessor);
    }

    @Test
    public void when_turning_left_should_return_a_new_view_point(){
        assertThat(initialViewPoint.turnLeft()).isNotNull().isNotEqualTo(initialViewPoint);
        verify(camera).turnLeft(90);
    }

}
