Feature: Adding to Favorites/Rename/Comment on File module functionality
  Agile story: As a user, I should be able to add a file to favorites, rename any file and give some comments on any file.
    AC1. User can add any file to favorites from its own three dots menu
    AC2. User can rename any file from its own three dots menu
    AC3. User can put some comments on any file from the file details menu opened right side
    AC4. User can delete the comments made on any file from the file details menu opened right side


@CEA-959 @1 @wip
  Scenario: Adding of any file to favorites verification
    Given user login and pass to All files
    When user clicks Add to favorites
    Then user should be able to see a yellow star right on the folder icon


@CEA-960 @2 #@wip
  Scenario: Renaming of any file verification
    Given user login and pass to All files
    When user clicks Rename
    And user enters a New name for file or folder and presses Enter key
    Then user should be able to see a changed name of file or folder


@CEA-961 @3 @wip
  Scenario: Adding of some comments on any file verification
    Given user login and pass to All files
    When user clicks Details
    And user clicks Comments
    And user enters a New comment text for file or folder and presses Enter key
    Then user should be able to see a recently written comment


@CEA-962 @4
  Scenario: Deleting of any comment verification
    Given user login and pass to All files
    When user clicks Details
    And user clicks Comments
    And user clicks on three dot icon near the comment that should be deleted
    Then user should be able to see that there is no recently deleted comment
