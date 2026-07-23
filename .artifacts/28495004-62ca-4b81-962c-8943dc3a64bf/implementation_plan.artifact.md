# Implement Dynamic Login/Logout in ProfileScreen

This plan describes how to make the Login/Logout button dynamic on the profile screen using a shared `UserViewModel`.

## Proposed Changes

### [Models]

#### [NEW] [UserViewModel.kt](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur%20-%20EK/2%20Semester/NeverAnother/app/src/main/java/com/example/neveranother/models/UserViewModel.kt)
- Create a new ViewModel to manage user authentication state.
- Include an `isLoggedIn` state and a `toggleLogin()` function to simulate logging in and out.

### [Screens]

#### [MODIFY] [ProfileScreen.kt](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur%20-%20EK/2%20Semester/NeverAnother/app/src/main/java/com/example/neveranother/screens/ProfileScreen.kt)
- Update `ProfileScreen` to accept `UserViewModel`.
- Change the Logout button to show "Log ud" or "Log ind" based on the ViewModel's state.
- Update the button's `onClick` to call `viewModel.toggleLogin()`.
- (Nice to have) Update the welcome text ("Hej Emma") and profile circle to be hidden or changed when logged out.

### [Navigation]

#### [MODIFY] [AppNavGraph.kt](file:///Users/nikolajrahe/Documents/Documents/It-arkitektur%20-%20EK/2%20Semester/NeverAnother/app/src/main/java/com/example/neveranother/navigation/AppNavGraph.kt)
- Create an instance of `UserViewModel` (scoped to the `NavHost` or a specific graph) and pass it to `ProfileScreen`.

## Verification Plan

### Manual Verification
1. Navigate to the Profile screen.
2. Verify it says "Log ud" initially.
3. Click "Log ud".
4. Verify the button text changes to "Log ind".
5. Verify other UI elements (like the name or profile circle) reflect the logged-out state.
