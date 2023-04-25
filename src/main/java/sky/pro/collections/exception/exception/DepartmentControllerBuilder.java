package sky.pro.collections.exception.exception;

public class DepartmentControllerBuilder {
    private DepartmentService departmentService;

    public DepartmentControllerBuilder setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
        return this;
    }

    public DepartmentController createDepartmentController() {
        return new DepartmentController(departmentService);
    }
}