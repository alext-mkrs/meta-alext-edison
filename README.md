Description:
============

This Yocto layer is a collection of various fixes and feature additions
for Intel Edison board's Linux image (based on Yocto).

**Layer maintainer:** Alex T <alext.mkrs@gmail.com>

This layer depends on the layers from the Edison BSP + meta-openembedded + meta-mono.
See README files in recipe directories for any additional dependencies and other
specific instructions.

This is work-in-progress, so take the commit messages into account before reusing recipes.

Some of the recipes are taken as-is from other layers (after they've tested to compile for Edison),
some are modified to build for Edison and some are written from scratch. Commit messages indicate,
which commit is what.

Feel free to ask questions through GitHub's bugtracker for the repo or
in Intel Edison Community at https://communities.intel.com/community/makers/edison/forums
